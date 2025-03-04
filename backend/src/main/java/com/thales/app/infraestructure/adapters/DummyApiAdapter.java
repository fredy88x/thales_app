package com.thales.app.infraestructure.adapters;

import com.thales.app.domain.model.Employee;
import com.thales.app.domain.port.out.DummyApiService;
import com.thales.app.infraestructure.dtos.DummyEmployeeListResponse;
import com.thales.app.infraestructure.dtos.DummyEmployeeResponse;
import com.thales.app.infraestructure.mapper.DummyEmployeeMapper;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class DummyApiAdapter implements DummyApiService {

  private final RestTemplate restTemplate;

  public DummyApiAdapter() {
    restTemplate = new RestTemplate();
  }

  private static final String BASE_URL = "http://dummy.restapiexample.com/api/v1";

  @Override
  @Retryable(
      retryFor = {RestClientException.class},
      maxAttempts = 3, backoff = @Backoff(delay = 2000, multiplier = 2)
  )
  public Optional<Employee> getEmployeeById(Integer id) {
    String uri = BASE_URL + "/employee/" + id;
    ResponseEntity<DummyEmployeeResponse> response = restTemplate.getForEntity(uri,
        DummyEmployeeResponse.class);
    return Optional.ofNullable(response.getBody())
        .map(DummyEmployeeResponse::getData)
        .map(DummyEmployeeMapper.INSTANCE::dummyEmployeeToEmployee);
  }


  @Override
  @Retryable(
      retryFor = {RestClientException.class},
      maxAttempts = 3, backoff = @Backoff(delay = 2000, multiplier = 2)
  )
  public List<Employee> getEmployees() {
    String uri = BASE_URL + "/employee";
    ResponseEntity<DummyEmployeeListResponse> response = restTemplate.getForEntity(uri,
        DummyEmployeeListResponse.class);
    if (response.getStatusCode().isError()) {
      return Collections.emptyList();
    }
    return Optional.ofNullable(response.getBody())
        .map(DummyEmployeeListResponse::getData)
        .stream()
        .flatMap(List::stream)
        .map(DummyEmployeeMapper.INSTANCE::dummyEmployeeToEmployee)
        .toList();
  }

  @Recover
  public List<Employee> recoverListEmployee() {
    return Collections.emptyList();
  }

  @Recover
  public Optional<Employee> recoverEmployee(Integer id) {
    return Optional.empty();
  }
}
