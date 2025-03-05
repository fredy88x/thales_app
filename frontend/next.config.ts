import path from "path";
import type { NextConfig } from "next";

const nextConfig: NextConfig = {
  output: "export",
  distDir: path.join("../backend/src/main/webapp/static"), 
};

export default nextConfig;
