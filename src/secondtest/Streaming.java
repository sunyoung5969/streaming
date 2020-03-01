package secondtest;

public class Streaming extends Thread {
	StMethod sm = new StMethod();

	void mP​remium(MediaInfo mi, String sub, String dub) {
		String c = mi.getCountry();

		if (c.equals("한국") && ( !sub.equals("KOR") && !sub.equals("없음") )
			|| c.equals("한국") && ( !dub.equals("KOR") && !dub.equals("없음") )) {
			streamingUHDKor();
			streamingUHDEng();
		} else if (c.equals("한국") && sub.equals("KOR") || c.equals("한국") && dub.equals("KOR")
				|| c.equals("한국") && sub.equals("없음") || c.equals("한국") && dub.equals("없음")) {
			streamingUHDKor();
		} else if (!c.equals("한국") && sub.equals("KOR") || !c.equals("한국") && dub.equals("KOR")) {
			streamingUHDEng();
			streamingUHDKor();
		} else if (!c.equals("한국") && sub.equals("없음") || !c.equals("한국") && dub.equals("없음"))
			streamingUHDEng();
		else if (!c.equals("한국") && !sub.equals("KOR") || !c.equals("한국") && !dub.equals("KOR"))
			streamingUHDEng();

	}

	void mStandard(MediaInfo mi, String sub, String dub) {
		String c = mi.getCountry();

		if (c.equals("한국") && (!sub.equals("KOR") && !sub.equals("없음"))
			|| c.equals("한국") && (!dub.equals("KOR") && !dub.equals("없음"))) {
			streamingHDKor();
			streamingHDEng();
		} else if (c.equals("한국") && sub.equals("KOR") || c.equals("한국") && dub.equals("KOR")
				|| c.equals("한국") && sub.equals("없음") || c.equals("한국") && dub.equals("없음")) {
			streamingHDKor();
		} else if (!c.equals("한국") && sub.equals("KOR") || !c.equals("한국") && dub.equals("KOR")) {
			streamingHDEng();
			streamingHDKor();
		} else if (!c.equals("한국") && sub.equals("없음") || !c.equals("한국") && dub.equals("없음"))
			streamingHDEng();
		else if (!c.equals("한국") && !sub.equals("KOR") || !c.equals("한국") && !dub.equals("KOR"))
			streamingHDEng();

	}

	void streamingUHDEng() {
		try {

			sleep(500);
			System.out.println("   ███████╗████████╗██████╗ ███████╗ █████╗ ███╗   ███╗██╗███╗   ██╗ ██████╗ ");
			sleep(250);
			System.out.println("   ██╔════╝╚══██╔══╝██╔══██╗██╔════╝██╔══██╗████╗ ████║██║████╗  ██║██╔════╝ ");
			sleep(250);
			System.out.println("   ███████╗   ██║   ██████╔╝█████╗  ███████║██╔████╔██║██║██╔██╗ ██║██║  ███╗");
			sleep(250);
			System.out.println("   ╚════██║   ██║   ██╔══██╗██╔══╝  ██╔══██║██║╚██╔╝██║██║██║╚██╗██║██║   ██║");
			sleep(250);
			System.out.println("   ███████║   ██║   ██║  ██║███████╗██║  ██║██║ ╚═╝ ██║██║██║ ╚████║╚██████╔╝");
			sleep(250);
			System.out.println("   ╚══════╝   ╚═╝   ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝╚═╝     ╚═╝╚═╝╚═╝  ╚═══╝ ╚═════╝ ");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void streamingUHDKor() {
		try {

			sleep(500);
			System.out.println("         ███╗            ██████████╗        █████████╗██╗      ████████╗ ██╗");
			sleep(250);
			System.out.println("        ██╔██╗           ██╔═══════╝        ╚══════██║██║      ██    ██║ ██║");
			sleep(250);
			System.out.println("       ██╔╝ ██╗          ██████████╗               ██║██║      ██    ██║ ██║");
			sleep(250);
			System.out.println("      ██╔╝   ██╗         ██╔═══════╝        █████████║██║      ████████║ ██║");
			sleep(250);
			System.out.println("     ██╔╝     ██╗        ██████████╗        ██╔══════╝██║      ╚══███████╗═╝");
			sleep(250);
			System.out.println("     ╚═╝      ╚═╝        ╚═════════╝        ██║       ██║        ██╔════██╗");
			sleep(250);
			System.out.println("    █████████████╗      █████████████╗      █████████╗██║        ╚███████╔╝");
			sleep(250);
			System.out.println("    ╚════════════╝      ╚════════════╝      ╚════════╝╚═╝         ╚══════╝ ");

		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	void streamingHDKor() {
		try {

			sleep(1000);
			System.out.println("         █ █╗            ██ ███████╗        ████ ████╗██╗      █████ ██╗ ██╗");
			sleep(300);
			System.out.println("        ██╔██╗           ██╔═══════╝        ╚══════██║ █║      ██    ██║  █║");
			sleep(300);
			System.out.println("       ██╔╝ ██╗          █████ ████╗               ██║██║      ██    ██║ █ ║");
			sleep(300);
			System.out.println("      ██╔╝   ██╗         ██╔═══════╝        ████ ████║██║      ██ █████║ ██║");
			sleep(300);
			System.out.println("     ██╔╝     ██╗        █████████ ╗        ██╔══════╝██║      ╚══███ ███╗═╝");
			sleep(300);
			System.out.println("     ╚═╝      ╚═╝        ╚═════════╝        ██║       █ ║        ██╔════██╗");
			sleep(300);
			System.out.println("    ██ ███████ ██╗      ██ ███████ ██╗      ████ ████╗██║        ╚███ ███╔╝");
			sleep(300);
			System.out.println("    ╚════════════╝      ╚════════════╝      ╚════════╝╚═╝         ╚══════╝ ");

		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	void streamingHDEng() {
		try {

			sleep(1000);
			System.out.println("   ███ ███╗█ ████ █╗██████╗ ███ ███╗ ██ ██╗ ███╗   ███╗██╗█ █╗   ██╗ ██ ███╗ ");
			sleep(300);
			System.out.println("   ██╔════╝╚══██╔══╝██╔══██╗██╔════╝██╔══██╗█ ██╗ ██ █║ █║████╗  ██║██╔════╝ ");
			sleep(300);
			System.out.println("   ███████╗   ██║   ███ ██╔╝█████╗  ███ ███║██╔████╔██║██║██╔██╗ ██║██║ ████╗");
			sleep(300);
			System.out.println("   ╚════██║   ██║   ██╔══██╗██╔══╝  ██╔══██║██║╚██╔╝██║█ ║██║╚██╗██║██║   ██║");
			sleep(300);
			System.out.println("   ███ ███║   ██║   ██║  ██║███ ███╗██║  ██║██║ ╚═╝ ██║██║██║ ╚██ █║╚███ ██╔╝");
			sleep(300);
			System.out.println("   ╚══════╝   ╚═╝   ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝╚═╝     ╚═╝╚═╝╚═╝  ╚═══╝ ╚═════╝ ");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class StMethod extends Thread {

}
