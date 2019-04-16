import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatEx {
	public static void main(String[] args) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		System.out.println(sdf.format(now));
		
		double num = 1234567.8989;
		DecimalFormat df1 = new DecimalFormat("#,###.###");
		DecimalFormat df2 = new DecimalFormat("0,000.00000");
		System.out.println(df1.format(num));
		System.out.println(df2.format(num));
	}
}
