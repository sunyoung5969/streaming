package secondtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ProductInputStream { // �������� �ҷ����� Ŭ����

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
		// ��Ʈ �� (ù��°���� �����ϹǷ� 0�� �ش�)
		// ���� �� ��Ʈ�� �б����ؼ��� FOR���� �ѹ��� �����ش�
		XSSFSheet sheet = workbook.getSheetAt(0);
		// ���� ��
		int rows = sheet.getPhysicalNumberOfRows();
		int count = 0;

		for (rowindex = 0; rowindex < rows; rowindex++) {
			// �����д´�
			XSSFRow row = sheet.getRow(rowindex);
			if (row != null) {
				// ���� ��
				int cells = row.getPhysicalNumberOfCells();
				for (columnindex = 0; columnindex <= cells; columnindex++) {
					// ������ �д´�

					XSSFCell cell = row.getCell(columnindex);
					String value = "";

					// ���� ���ϰ�츦 ���� ��üũ
					if (cell == null) {
						continue;
					} else {
						// Ÿ�Ժ��� ���� �б�
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
