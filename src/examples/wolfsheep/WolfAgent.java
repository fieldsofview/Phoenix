/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.wolfsheep;

import agents.AIDGenerator;
import system.Log;

public class WolfAgent extends agents.Agent {

    private int xcor;
    private int ycor;
    
    public WolfAgent(AIDGenerator aidGenerator) {
        super(aidGenerator);
        Log.ConfigureLogger();
    }

    @Override
    public void run() {
        Log.logger.info("Running " + this.getClass().getCanonicalName() +": "+ this.getAID());
        this.setStatusFlag(true);
        this.setObjectiveFlag(true);
    }
    
    public void setCoordinates(int xcor,int ycor){
        this.xcor=xcor;
        this.ycor=ycor;
    }
}