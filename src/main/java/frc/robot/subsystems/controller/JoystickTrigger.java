package frc.robot.subsystems.controller;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;

public class JoystickTrigger  extends Button {

    private final GenericHID m_joystick;
    private final int m_triggerNumber;

    /**
     * Create a joystick button for triggering commands.
     *
     * @param joystick The GenericHID object that has the button (e.g. Joystick, KinectStick, etc)
     * @param triggerNumber The button number (see {@link GenericHID#getRawAxis(int) }
     */
    public JoystickTrigger(GenericHID joystick, int triggerNumber)
    {
        m_joystick = joystick;
        m_triggerNumber = triggerNumber;
    }

    /**
     * Gets the value of the joystick trigger.
     *
     * @return True if the value of the joystick trigger is X
     */
    @Override
    public boolean get() {
        // Return true if the trigger is being pressed. 
        
        return (m_joystick.getRawAxis(m_triggerNumber) == 1);
    }

    
}
