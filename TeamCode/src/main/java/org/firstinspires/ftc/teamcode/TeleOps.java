package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

@TeleOp
public class TeleOps extends LinearOpMode {


    public DcMotor frontRight;
    public DcMotor frontLeft;
    public DcMotor backLeft;
    public DcMotor backRight;
    public DcMotor hookLifter;
    public Servo clawGrabber;
    public DcMotor clawWrist;
    public DcMotor clawArmRight;
    public DcMotor clawArmLeft;
    public Servo airplaneLauncher;
    public TouchSensor touchSensor;


    @Override
    public void runOpMode() {

        touchSensor = hardwareMap.get(TouchSensor.class, "touchSensor");

        frontRight = hardwareMap.get(DcMotor.class, "frontRight");


        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");


        backLeft = hardwareMap.get(DcMotor.class, "backLeft");


        backRight = hardwareMap.get(DcMotor.class, "backRight");


        clawGrabber = hardwareMap.get(Servo.class, "clawGrabber");


        clawWrist = hardwareMap.get(DcMotor.class, "clawWrist");


        hookLifter = hardwareMap.get(DcMotor.class, "hookLifter");


        clawArmRight = hardwareMap.get(DcMotor.class, "clawArmRight");
        clawArmLeft = hardwareMap.get(DcMotor.class, "clawArmLeft");


        airplaneLauncher = hardwareMap.get(Servo.class, "airplaneLauncher");


        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        clawArmRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        clawArmLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        clawArmRight.setDirection(DcMotorSimple.Direction.REVERSE);


        telemetry.addData("Status", "Initialized");
        telemetry.update();

        double drivespeed = 1;

        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.right_bumper) {
                frontLeft.setPower(-drivespeed);
                frontRight.setPower(drivespeed);
                backLeft.setPower(-drivespeed);
                backRight.setPower(drivespeed);
            } else if (gamepad1.left_bumper) {
                frontLeft.setPower(drivespeed);
                frontRight.setPower(-drivespeed);
                backLeft.setPower(drivespeed);
                backRight.setPower(-drivespeed);
            } else {
                frontLeft.setPower(0);
                frontRight.setPower(0);
                backLeft.setPower(0);
                backRight.setPower(0);
            }
//
//            else if (gamepad1.left_stick_y > 0.9) {
//                frontLeft.setPower(drivespeed);
//                frontRight.setPower(drivespeed);
//                backLeft.setPower(drivespeed);
//                backRight.setPower(drivespeed);
//            }
//            else if (gamepad1.left_stick_y < -0.9) {
//                frontLeft.setPower(-drivespeed);
//                frontRight.setPower(-drivespeed);
//                backLeft.setPower(-drivespeed);
//                backRight.setPower(-drivespeed);
//            }
//
//            else if (gamepad1.left_stick_x > 0.9) {
//                frontLeft.setPower(-drivespeed);
//                frontRight.setPower(drivespeed);
//                backLeft.setPower(drivespeed);
//                backRight.setPower(-drivespeed);
//            }
//            else if (gamepad1.left_stick_x < -0.9) {
//                frontLeft.setPower(drivespeed);
//                frontRight.setPower(-drivespeed);
//                backLeft.setPower(-drivespeed);
//                backRight.setPower(drivespeed);
//            }
//            else {
//                frontLeft.setPower(0);
//                frontRight.setPower(0);
//                backLeft.setPower(0);
//                backRight.setPower(0);
//            }


            double speed = gamepad1.left_stick_y;
            double strafe = -gamepad1.left_stick_x;
            frontLeft.setPower(speed + strafe);
            frontRight.setPower(speed - strafe);
            backLeft.setPower(speed - strafe);
            backRight.setPower(speed + strafe);


            //hookLifter
            if (gamepad1.a) {
                hookLifter.setPower(1);
            } else if (gamepad1.b) {
                hookLifter.setPower(-1);
            } else {
                hookLifter.setPower(0);
            }


            //clawArm
            if (gamepad2.dpad_up) {
                clawArmRight.setPower(.7);
            } else if (gamepad2.dpad_down) {
                clawArmRight.setPower(-.7);
                clawArmLeft.setPower(-.7);
            } else {
                clawArmRight.setPower(0);
                clawArmLeft.setPower(0);
            }


            //clawWrist
            if (gamepad2.left_stick_y > .9) {
                clawWrist.setPower(.5);
            } else if (gamepad2.left_stick_y < -0.9) {
                clawWrist.setPower(-.5);
            } else {
                clawWrist.setPower(0);
            }


            //clawGrabber
            if (gamepad2.right_stick_x > 0.9) {
                clawGrabber.setPosition(.9);
            } else if (gamepad2.right_stick_x < -0.9) {
                clawGrabber.setPosition(-.9);
            } else {
                clawGrabber.setPosition(0);
            }


            //airplaneLauncher
            if (gamepad2.x) {
                airplaneLauncher.setPosition(0);
            } else {
                airplaneLauncher.setPosition(1);
            }
//            //touchSensor
//            if (touchSensor.isPressed()) {
//                frontLeft.setPower(0);
//                backRight.setPower(0);
//                backLeft.setPower(0);
//                frontRight.setPower(0);
//                telemetry.addData("button: ", "is pressed");
//                sleep(1500);
//            }
////            else if(touchSensor.getValue(1)) {
////
////            }
//            telemetry.update();
        }







//        SCRAP?????

//        if (gamepad2.dpad_up) {
//
//            clawArmLeft.setTargetPosition(188);
//            clawArmRight.setTargetPosition(188);
//            loop();
//        }
//        if (gamepad2.dpad_down) {
//            clawArmLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            clawArmRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//            clawArmLeft.setTargetPosition(0);
//            clawArmRight.setTargetPosition(0);
//        }
////        clawArmLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
////        clawArmRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
////
////        clawArmLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
////        clawArmRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//
//        clawArmLeft.getCurrentPosition();
//
//        int ANDYMARK_TICKS_PER_REV = 1120;
    }
}


