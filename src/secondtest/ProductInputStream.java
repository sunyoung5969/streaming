package secondtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ProductInputStream { // 엑셀파일 불러오기 클래스

	Singleton sgsg = Singleton.getInstance();

	void mediaRead() throws IOException {

		FileInputStream fis;

		ArrayList<String> arrayName = new ArrayList<String>();
		ArrayList<String> arrayMovieRatings = new ArrayList<String>();
		ArrayList<String> arrayRunningTime = new ArrayList<String>();
		ArrayList<String> arrayFilmDrector = new ArrayList<String>();
		ArrayList<String> arrayLeadActor = new ArrayList<String>();
		ArrayList<String> arrayGenre = new ArrayList<String>();
		ArrayList<String> arrayCountry = new ArrayList<String>();
		ArrayList<String> arrayReleaseYear = new ArrayList<String>();
		ArrayList<String> arraySub = new ArrayList<String>();
		ArrayList<String> arrayDubbing = new ArrayList<String>();

		fis = new FileInputStream("C:\\Users\\Sun\\Desktop\\191201/a.xlsx");
		XSSFWorkbook workbook;

		workbook = new XSSFWorkbook(fis);
		String[] info = new String[10];
		ArrayList<String[]> allinput = new ArrayList<String[]>();

		int rowindex = 0;
		int columnindex = 0;
		// 시트 수 (첫번째에만 존재하므로 0을 준다)
		// 만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
		XSSFSheet sheet = workbook.getSheetAt(0);
		// 행의 수
		int rows = sheet.getPhysicalNumberOfRows();
		int count = 0;

		for (rowindex = 0; rowindex < rows; rowindex++) {
			// 행을읽는다
			XSSFRow row = sheet.getRow(rowindex);
			if (row != null) {
				// 셀의 수
				int cells = row.getPhysicalNumberOfCells();
				for (columnindex = 0; columnindex <= cells; columnindex++) {
					// 셀값을 읽는다

					XSSFCell cell = row.getCell(columnindex);
					String value = "";

					// 셀이 빈값일경우를 위한 널체크
					if (cell == null) {
						continue;
					} else {
						// 타입별로 내용 읽기
						switch (cell.getCellType()) {

						case STRING:
							value = cell.getStringCellValue();
							break;
						case NUMERIC:
							value = String.valueOf((int) (cell.getNumericCellValue()));
							break;
						}

						info[count] = value;
						count++;

					}

					if (count == 10) {
						arrayName.add(info[0]);				arrayMovieRatings.add(info[1]);
						arrayRunningTime.add(info[2]);		arrayFilmDrector.add(info[3]);
						arrayLeadActor.add(info[4]);		arrayGenre.add(info[5]);
						arrayCountry.add(info[6]);			arrayReleaseYear.add(info[7]);
						arraySub.add(info[8]);				arrayDubbing.add(info[9]);

						count = 0;

					}

				}

			}

		}
//		
//		for (int i = 0; i < arrayName.size(); i++) {
//			System.out.println(arrayName.get(i));
//		}
		
		for (int i = 0; i < arrayName.size(); i++) {
			MediaInfo mi = new MediaInfo();
			mi.setMediaName(arrayName.get(i));
			mi.setMovieRatings(arrayMovieRatings.get(i));
			mi.setRuningTime(arrayRunningTime.get(i));
			mi.setFilmDrector(arrayFilmDrector.get(i));
			mi.setLeadActor(arrayLeadActor.get(i));
			mi.setGenre(arrayGenre.get(i));
			mi.setCountry(arrayCountry.get(i));
			mi.setReleaseYear(arrayReleaseYear.get(i));
			mi.setSubtitles(arraySub.get(i));
			mi.setDubbing(arrayDubbing.get(i));
			
			sgsg.mediaInfo.add(mi);
			
		}
//		for (int i = 0; i < arrayName.size(); i++) {
//		System.out.println(sgsg.mediaInfo.get(i).getMediaName());
//		}
	}
}
