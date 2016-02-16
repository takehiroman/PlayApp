package controllers;

import play.*;
import play.data.*;
import static play.data.Form.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
    
    //フォーム内の内部クラス
    public static class SampleForm {
        public String message;
    }
        
    //ルートにアクセスした際のアクション
    public Result index() {
        return ok(index.render("何か書いて",new Form(SampleForm.class)));
    }
    
    //sendにアクセスした際のアクション
    public Result send() {
      Form<SampleForm> f =   form(SampleForm.class).bindFromRequest();
      if(!f.hasErrors()){
      SampleForm data = f.get();
      String msg = "you typed:" + data.message;
      return ok(index.render(msg,f));
      } else {
        return badRequest(index.render("ERROR",form(SampleForm.class)));      
      }
    }
}

