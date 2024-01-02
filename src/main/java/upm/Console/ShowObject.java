package upm.Console;

import java.util.List;

public class ShowObject<T> {
    private View view;

     ShowObject () {
    }

    public void showInformation (T object){
        view.show(object.toString());
    }
    public void showListInformation (List<T> objects){
        for (T object : objects){
            showInformation(object);
        }
    }
}
