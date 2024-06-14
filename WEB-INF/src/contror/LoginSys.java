package contror;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EmpInfo;
import model.employee; 
// URL パターン
@WebServlet("/login")
public class LoginSys extends HttpServlet{
 // サーブレットの開始メソッド doPost()
 public void doPost(HttpServletRequest request,
 HttpServletResponse response)
 throws ServletException, IOException{
 // メッセージを格納
 String msg = "";
 // 移動先を格納 <デフォルトはログイン画面>
 String forwardName = "/View/login.jsp";
 // request 情報のエンコーディング
 request.setCharacterEncoding("UTF-8");
 // response 情報のエンコーディング
 response.setContentType("text/html;charset=UTF-8");
 // form 情報の取得
 String f_id = request.getParameter("id");
 String f_pass = request.getParameter("pass"); 
 // 社員情報 
 employee emp = null; 
 if (f_id == null || f_pass == null) {
 msg = "ログイン情報の取得に失敗しました";
 } else {
 // 社員情報取得クラスの生成 
 EmpInfo einfo = new EmpInfo(); 
 // 社員情報取得 
 emp = einfo.getEmployee(f_id, f_pass); 
 // ログイン情報が合致
 if (emp != null) { 
	 msg = "ログインに成功しました";
	 // 移動先を確認画面に設定
	 forwardName = "/View/confilm.jsp";
	 }
	 // ログイン情報が不一致
	 else {
	 msg = "ログイン ID またはパスワードに誤りがあります";
	 }
	 }
	 // リクエストスコープにメッセージを格納
	 request.setAttribute("message", msg);
	 // セッションスコープに社員情報を格納 
	 HttpSession session = request.getSession(); 
	 session.setAttribute("emp", emp); 
	 // Web アプリケーション内の情報やいろいろな機能の収集
	 ServletContext application = getServletContext();
	 // 移動先の指定
	 RequestDispatcher rd =
	 application.getRequestDispatcher(forwardName);
	 // リクエスト・レスポンス情報を渡して移動
	 rd.forward(request, response);
	 }
	}
