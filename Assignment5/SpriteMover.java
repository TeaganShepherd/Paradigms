public class SpriteMover implements Runnable {
    public Model model;
    public View view;
    public SpriteMover(Model m, View v){
        model = m;
        view = v;

    }

    public void run() {
        while (true) {
    
            //... cause the scene to be updated here ...
            model.updateScene(view.getWidth(),view.getHeight());
            //... cause the scene to be redrawn here ...
            view.repaint();
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {}
        }

    }
}