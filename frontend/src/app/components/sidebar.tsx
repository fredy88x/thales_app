import Link from "next/link";
import { Nav } from "react-bootstrap";
import { FaUser } from "react-icons/fa";
import Image from "next/image";

export default function Sidebar() {
  return (
    <aside className="sidebar">
      <Image
        className="styles.logo"
        src="/next.svg"
        alt="Next.js logo"
        width={180}
        height={38}
        priority
      />
      <h2 className="text-lg font-bold mb-4">Menú</h2>
      <Nav className="flex-column">
        <Link href="/" className="nav-link" passHref>
          <FaUser />
          Employee
        </Link>
      </Nav>
    </aside>
  );
}
