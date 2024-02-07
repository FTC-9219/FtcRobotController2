package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

import java.util.List;

@Autonomous
public class BlueFrontWebcam extends LinearOpMode {
    public DcMotor frontLeft;
    public DcMotor backLeft;
    public DcMotor frontRight;
    public DcMotor backRight;
    public Servo clawGrabber;
    public DcMotor clawWrist;
    public DcMotor clawArmRight;
    public DcMotor clawArmLeft;
    public TfodProcessor visionProcessor;
    TfodProcessor tfodProcessor = TfodProcessor.easyCreateWithDefaults();

    @Override
    public void runOpMode() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight ");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");

        WebcamName camera = hardwareMap.get(WebcamName.class, "webcam1");
        VisionPortal visionPortal = VisionPortal.easyCreateWithDefaults(camera, visionProcessor);

        clawArmLeft = hardwareMap.get(DcMotor.class, "clawArmLeft");
        clawArmRight = hardwareMap.get(DcMotor.class, "clawArmRight");
        clawGrabber = hardwareMap.get(Servo.class, "clawGrabber");
        clawWrist = hardwareMap.get(DcMotor.class, "clawWrist");


        List<Recognition> recognitions = tfodProcessor.getRecognitions();
        for (Recognition recognition : recognitions) {
            String label = recognition.getLabel();
            float confidence = recognition.getConfidence();

            telemetry.addLine("Recognized Object: " + label);
            telemetry.addLine("Confidence" + confidence);
        }
        float fps = visionPortal.getFps();

        visionPortal.setProcessorEnabled(visionProcessor, false);
    }
}
