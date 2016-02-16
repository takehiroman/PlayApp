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
    
    //新規作成フォームのaction
    public Result add(){
        Form<Message> f = new Form(Message.class);
        return ok (add.render("投稿フォーム",f));
    }
    
    //createにアクセスした際のアクション
    public Result create(){
        Form<Message> f = new Form(Message.class).bindFromRequest();
        if(!f.hasErrors()){
            Message data = f.get();
            data.save();
            return redirect("/");
        }else{
            return badRequest(add.render("ERROR",f));
        }
    }
    
    
}

