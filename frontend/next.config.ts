import path from "path";
import type { NextConfig } from "next";

const nextConfig: NextConfig = {
  output: "export",
  distDir: path.join(__dirname, "../backend/src/main/resources/static"), 
};

export default nextConfig;
