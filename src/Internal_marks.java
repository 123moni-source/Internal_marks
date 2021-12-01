import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Internal_marks {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Internal_Marks", "root", "");
        String phone="8791234565 hgjfutr jhgftrh 07653482794";
        String name="Ritika Aman Ram jam";
        Pattern p=Pattern.compile("(0|91)?[7-9][0-9]{9}");
        Pattern p2=Pattern.compile("[ar][a-zA-Z]*",Pattern.CASE_INSENSITIVE);
        Matcher m=p.matcher(phone);
        Matcher m2=p2.matcher(name);
        PreparedStatement pr=con.prepareStatement("Give information?,?)");
        String[] ar1=new String[100];
        long[] ar2=new long[100];
        int c=0;
        int d=0;
        while(m2.find())
        {
            ar1[c++]=m2.group();
            // System.out.println(ar1[0]);
        }
        while(m.find())
        {
            ar2[d++]=Long.parseLong(m.group());
        }
        try {
            if (c>=1 && d>=1) {
                for(int i=0;i<Math.min(c,d);i++)
                {
                    pr.setLong(1,ar2[i]);
                    pr.setString(2,ar1[i]);
                    pr.execute();
                }

            } else {
                throw new InvalidDataException("Invalid String");
            }
        }
        catch (Exception obj)
        {
            System.out.println(obj.getMessage());
        }
    }
}

