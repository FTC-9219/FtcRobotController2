package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class redFront extends LinearOpMode {
    public DcMotor frontLeft;
    public DcMotor backLeft;
    public DcMotor frontRight;
    public DcMotor backRight;

    @Override
    public void runOpMode() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight ");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");



        waitForStart();
        Nothing(.5, 1000);
        Forward(.5, 10);
        Nothing(.5, 500);
        StrafeRight(.5, 2000);

    }
    public void Nothing(double power, long time) { //editing codes
        frontLeft.setPower(power*0);
        backLeft.setPower(power*0);
        frontRight.setPower(power*0);
        backRight.setPower(power*0);
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
}

