# Chess

Current classes:
	
- Board.java // needs to be written
- BoardTest.java // needs to be written

- Component.java // needs to be updated
        public static void main(String[] args) - Adds Component and Window object, adds Component object to the Window object.
        public void init() - Makes isRunning true, initializes and starts a new thread.
        public void run() - While isRunning, activates tick() and render() then tries a thread.sleep(20).
        public void tick() - Currently empty.
        public void render(Graphics g) - Initializes image buffer, Draws a gray rectangle.

- Window.java
        public Window(int width, int height, String title) - Sets title, window size, resize bool and visibility.

- Listening.java // needs to be written
- PieceImageManager.java // needs to be written
- Space.java // needs to be written
