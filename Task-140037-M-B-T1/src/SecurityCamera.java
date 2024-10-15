import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

public class SecurityCamera {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        VideoCapture camera = new VideoCapture(0);

        if (!camera.isOpened()) {
            System.out.println("Error opening camera.");
            return;
        }

        Mat frame = new Mat();

        while (true) {
            if (!camera.read(frame)) {
                System.out.println("Error reading camera frame.");
                break;
            }

            // Perform machine vision processing here
            // For example, object detection
            // ...

            // Save the frame as an image (for demo purposes)
            Imgcodecs.imwrite("output.jpg", frame);

            // You can also display the frame using an external library for GUI like OpenCV's imshow
        }

        camera.release();
    }
}

