# Chess

Current classes:

- Component.java:
        public static void main() - Adds Component and Window object, adds Component object to the Window object.
        public void init() - Makes isRunning true, initializes and starts a new thread.
        public void run() - While isRunning, activates tick() and render() then tries a thread.sleep(20).
        public void tick() - Currently empty.
        public void render() - Initializes image buffer, Draws a blue rectangle.

- Window.java
        public Window(int width, int height, String title) - Sets title, window size, resize bool and visibility.