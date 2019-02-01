import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * @author stevenw
 * @date 2018/7/18
 */
public class TestServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TestService service = new TestService();
        Object lock = new Object();
        synchronized(LockFlag.lock){
            while (LockFlag.flag){
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        }
        String message =  service.sendMessage();
        Writer writer =  resp.getWriter();
        writer.write(message);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
