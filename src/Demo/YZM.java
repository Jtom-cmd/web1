package Demo;

import com.sun.deploy.nativesandbox.comm.Response;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.Random;
import java.awt.image.BufferedImage;

/**
 * FJL
 **/
@WebServlet(name = "YZM",urlPatterns = "/yzm")
public class YZM  extends HttpServlet {

Random random =new Random();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedImage image =new BufferedImage(90, 80, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(Color.green);
       g.fillRect(0, 0, 90, 30);
       for (int i=0;i<10;i++){
           g.setColor(getColo());
           int x1= random.nextInt(91);
           int y1= random.nextInt(31);
           int x2=random.nextInt(91);
           int y2=random.nextInt(31);
           g.drawLine(x1, y1, x2, y2);

             
           char[] chars={'1','2','3','4','5','6','7','8'};
           StringBuilder checkCode=new StringBuilder();
           for (int j=0;j<4;j++){
               int index=random.nextInt(chars.length);
              checkCode.append(chars[index]);
           }

           for (int a=0;a<checkCode.length();a++){
            char temp=checkCode.toString().charAt(a);
            g.setColor(getColo());
            g.drawString(temp+"", 10+(i*20), 15);
           }

           ImageIO.write(image, "png", resp.getOutputStream());
       }




    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
              doGet(req, resp);
    }

    public Color getColo(){
        int r =random.nextInt(256);
        int g =random.nextInt(256);
        int b =random.nextInt(256);
   return  new Color(r,g,b);


    }
}
