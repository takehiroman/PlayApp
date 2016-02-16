package controllers;

import play.*;
import play.data.*;
import static play.data.Form.*;
import play.mvc.*;
import java.util.*;
import models.*;

import views.html.*;

public class Application extends Controller {
    
    //フォーム内の内部クラス
    public static class SampleForm {
        public String message;
    }
        
    //ルートにアクセスした際のアクション
    public Result index() {
        List<Message> datas = Message.find.all();
        return ok(index.render("データベースのサンプル",datas));
    }
    
    
}

