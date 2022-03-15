package frc.robot.subsystems;

import edu.wpi.first.math.controller.HolonomicDriveController;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.Vision.Limelight;
import frc.robot.subsystems.Vision.PrecisionAim;
import frc.robot.subsystems.drivetrain.SwerveWheelController;

public class AutoCommandModule {

    private Shooter shootModule;
    private Spool spoolModule;
    private Intake intakeModule;
    private SwerveWheelController driveModule;
    private Indexer indexerModule;
    private Elevator elevatorModule;
    private Limelight limeModule;
    private boolean inStartUp = false;
    private boolean ballLoaded = false;
    private boolean targetSighted = false;
    private PrecisionAim aimBot;
    

    public AutoCommandModule(Shooter shoot, Spool spool, Intake intake, 
                             SwerveWheelController drive, Indexer index, Elevator elevator,
                             Limelight lime)
    {
        shootModule = shoot;
        spoolModule = spool;
        intakeModule = intake;
        driveModule = drive;
        indexerModule = index;
        elevatorModule = elevator;
        limeModule = lime;
        aimBot = new PrecisionAim(0.5, 0, 0, lime, drive);

    }

    
    public void doStartUp()
    {
        
        spoolShooter();

        loadBall();

        fireShot();
        
    }


    // Periodic method implementing the base command structure
    public void periodic()
    {

        if (inStartUp)
        {
            doStartUp();
        }
        else
        {            
            if (!targetSighted)
            {
                targetSighted = SeekTarget();
            }
            else{
                
                if (!TargetSighted())
                {
                    System.out.printf("Aiming\n");
                    aimBot.NewTarget();
                }
                
            }
        }        
    }    

    public void fireShot()
    {
        //if (spoolModule.isShooterSpooled() && ballLoaded)
        //{
            if (!shootModule.isShotFired())
            {
                shootModule.fireShooter();
                elevatorModule.elevatorDown();
            }         
       // }
    }

    public void loadBall()
    {
        if (!ballLoaded)
        {
            if (!indexerModule.indexingStarted())
            {
                indexerModule.indexBall();
            }
            
            if (indexerModule.ballIndexed())
            {
                ballLoaded = true;
                System.out.printf("Ball Indexed\n");
                indexerModule.indexerOff();
            }
        }
    }

    public void spoolShooter()
    {
        if (!spoolModule.isShooterSpooled())
        {
            spoolModule.SpoolShooter();
        }
    }

    public boolean SeekTarget()
    {
        boolean foundTarget = false;

        // Stop if we get a target reading
        if (limeModule.validTargets())
        {
            driveModule.turnAtSpeed(0, 90);
            foundTarget = true;
        }
        else{
            // Start turning        
            driveModule.turnAtSpeed(0.15, 90);
        }

        return foundTarget;
    }

    public void AimToTarget()
    {
        driveModule.turnAtSpeed(0, 90);
    }

    public boolean TargetSighted()
    {
        boolean sighted = false;

        if (limeModule.validTargets())
        {
            if ((limeModule.targetX() < 0.5) && (limeModule.targetX() > -0.5))
            {
                sighted = true;
            }
        }

        return sighted;
    }

}
