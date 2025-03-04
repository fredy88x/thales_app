import Link from "next/link";
import Image from "next/image";

export default function Sidebar() {
  return (
    <aside className="w-64 bg-gray-900 text-white p-4">
      <Image
        className="styles.logo"
        src="/next.svg"
        alt="Next.js logo"
        width={180}
        height={38}
        priority
      />
      <h2 className="text-lg font-bold mb-3">Menú</h2>
      <nav className="space-y-2">
        <Link href="/" className="flex p-2 rounded-md bg-gray-700" passHref>
          <span className="m-2">Employee</span>
        </Link>
        <Link href="/other" className="flex p-2 rounded-md bg-gray-700" passHref>
          <span className="m-2">Other</span>
        </Link>
      </nav>
    </aside>
  );
}
