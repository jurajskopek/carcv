/**
 * 
 */
package org.carcv.web.reports;

import java.io.File;
import java.net.URL;
import java.util.Date;

import net.sf.jasperreports.engine.JRException;

import org.carcv.impl.core.model.Address;
import org.carcv.impl.core.model.CarData;
import org.carcv.impl.core.model.Entry;
import org.carcv.impl.core.model.NumberPlate;
import org.carcv.impl.core.model.MediaObject;
import org.carcv.core.model.MediaType;
import org.carcv.impl.core.model.Speed;
import org.carcv.core.model.SpeedUnit;
import org.carcv.web.reports.BasicReportGenerator;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author oskopek
 * 
 */
public class BasicReportGeneratorTest {

	private static Entry testEntry = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Speed speed = new Speed(80d, SpeedUnit.KPH);

		Address location = new Address("Myjava", "90701", "Jablonská",
				"Slovakia", 27, 860);

		NumberPlate licencePlate = new NumberPlate("MY-077AU", "SK");

		Date timestamp = new Date(System.currentTimeMillis());

		MediaObject video = new MediaObject("reports/OpenCV_Logo_with_text.png",
				MediaType.H264);

		CarData carData = new CarData(speed, location, licencePlate, timestamp);

		testEntry = new Entry(carData, video);
	}

	/**
	 * Test method for
	 * {@link org.carcv.web.reports.BasicReportGenerator#buildPDFReport(org.carcv.core.model.Entry, java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws JRException
	 */
	@Test
	public void testBuildPDFReport() throws JRException {
		URL testDir = getClass().getResource("/");

		File test_results_dir = new File(testDir.getPath() + "/test_results/");
		if (!test_results_dir.exists() || !test_results_dir.isDirectory()) {
			test_results_dir.mkdir();
		}
		//System.out.println("OutDir: " + test_results_dir.getPath());

		String filename = testDir.getPath() + "/test_results/report"
				+ System.currentTimeMillis() + ".pdf";
		
		BasicReportGenerator brg = new BasicReportGenerator(
				testEntry,
				"/reports/speed_report.jasper", "Myjava",
				"TestReport");
		
		brg.exportFile(filename);
	}

}
