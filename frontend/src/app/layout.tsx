"use client";
import "bootstrap/dist/css/bootstrap.css";
import "./globals.css";
import Sidebar from "./components/sidebar";


export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en" suppressHydrationWarning>
      <body>
        <div className="flex h-screen">
          <Sidebar />
          <main className="flex-1 p-6 bg-gray-100 overflow-auto">
            {children}
          </main>
        </div>
      </body>
    </html>
  );
}
