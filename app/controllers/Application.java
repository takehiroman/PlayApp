package controllers;

import play.*;
import play.data.*;
import static play.data.Form.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
    
    //フォーム内の内部クラス
    public static class SampleForm{
        public String message;
        
    //ルートにアクセスした際のアクション
    public static Result index(){
        return ok(index.render("何か書いて",new Form(SampleForm.class)));
        }
    
    //sendにアクセスした際のアクション
    public static Result send(){
      Form<SampleForm> f =   form(SampleForm.class).bindFormRequest();
      if(!f.haserrors()){
      }
      SampleForm data = f.get();
      String msg = "you typed" + data.message;
      retun ok(index.render(msg.f));
    } else {
        return badrequest(index.render("ERROR",form(SampleForm.class));
        }     
    }
}
