# Thales App

This web application allow us search an employee by id or list all employees availables from Rest Api.

## Architecture

This application is based on MVC pattern thorugt of a monolitic architecture using Java to backend and React to frontend.

### Backend

The Rest API is building with Java and hexagonal architecture to separate the diferent logic.

### Frontend

The user interface use next js framework with react and boostrap to build the diferent components.

## Setup

1. Clone de proyect.

    git clone https://github.com/fredy88x/thales_app.git

2. First we must install node  and pnpm libraries to compile the frontend side.

3. Install de node modules
    
    cd /frontend

    pnpm install

4. Install frontend application.

    pnpm build

5. Generate war file.

    ./gradlew clean build
    
    ./gradlew bootRun


