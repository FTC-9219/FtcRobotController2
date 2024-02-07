package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;


@Autonomous
public class blueFrontColor extends LinearOpMode {
    public DcMotor frontLeft;
    public DcMotor backLeft;
    public DcMotor frontRight;
    public DcMotor backRight;
    public RevColorSensorV3 colorSensor;
    public Servo clawGrabber;
    public DcMotor clawWrist;
    public DcMotor clawArmRight;
    public DcMotor clawArmLeft;

    @Override
    public void runOpMode() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight ");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");

        colorSensor = hardwareMap.get(RevColorSensorV3.class, "colorSensor");

        clawArmLeft = hardwareMap.get(DcMotor.class, "clawArmLeft");
        clawArmRight = hardwareMap.get(DcMotor.class, "clawArmRight");
        clawGrabber = hardwareMap.get(Servo.class, "clawGrabber");
        clawWrist = hardwareMap.get(DcMotor.class, "clawWrist");

        waitForStart();
        // move...
        // sensor sees a certain value of blue
        // stop
        // unload one pixel
        // drive to board
        // let go of pixel
        // park

        StrafeLeft(.2, 4000);

        while (colorSensor.getDistance(DistanceUnit.CM) > 2 && opModeIsActive()) {
                colorSensor.getDistance(DistanceUnit.CM);
                telemetry.update();
                telemetry.addData("Distance CM", colorSensor.getDistance(DistanceUnit.CM));
                telemetry.addData("Red", colorSensor.red());
                telemetry.addData("Green", colorSensor.green());
                telemetry.addData("Blue", colorSensor.blue());
                telemetry.update();
                Forward(.2, 5000);
                SpinRight(.2, 4000);
                Forward(.2, 6000);
                StrafeRight(.2, 5000);
        }



        Nothing(1000);
        armUp(3000);
        wristDown(5000);
        armDown(5000);
        grabOpen(5000);

    }
    public void armUp(long time) {
        clawArmRight.setPower(1);
        clawArmLeft.setPower(1);
    }
    public void wristDown(long time) {
        clawWrist.setPower(-1);
    }
    public void grabOpen(long time) {
        clawGrabber.setPosition(-1);
    }
    public void armDown(long time) {
        clawArmRight.setPower(1);
        clawArmLeft.setPower(1);
    }
    public void Nothing(long time) { //editing codes
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
        sleep(time);

    }
    public void Backward(double power, long time) {
        frontLeft.setPower(power);
        backLeft.setPower(power);
        frontRight.setPower(power*-1);
        backRight.setPower(power);
        sleep(time);
    }

    public void Forward(double power, long time) {
        frontLeft.setPower(power * -1);
        backLeft.setPower(power * -1);
        frontRight.setPower(power);
        backRight.setPower(power * -1);
        sleep(time);
    }

    public void StrafeLeft(double power, long time) {
        frontRight.setPower(power);
        backLeft.setPower(power*-1);
        frontLeft.setPower(power);
        backRight.setPower(power);
        sleep(time);
    }

    public void StrafeRight(double power, long time) {
        frontLeft.setPower(power*-1);
        backLeft.setPower(power);
        frontRight.setPower(power * -1);
        backRight.setPower(power*-1);
        sleep(time);
    }

    public void SpinLeft(double power, long time) {
        frontLeft.setPower(power);
        backLeft.setPower(power);
        frontRight.setPower(power);
        backRight.setPower(power*-1);
        sleep(time);
    }

    public void SpinRight(double power, long time) {
        frontLeft.setPower(power*-1);
        backLeft.setPower(power*-1);
        frontRight.setPower(power * -1);
        backRight.setPower(power);
        sleep(time);
    }

    public void colorSense() {
        colorSensor.getDistance(DistanceUnit.CM);
        telemetry.addData("Red", colorSensor.red());
        telemetry.addData("Green", colorSensor.green());
        telemetry.addData("Blue", colorSensor.blue());
        telemetry.update();

//    if (DistanceUnit.CM < 180) {
//    frontLeft.setPower(power * -1);
//    backLeft.setPower(power * -1.);
//    frontRight.setPower(power);
//    backRight.setPower(power * -1);
//    sleep(time);
    }

}



