/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. and 
 * at http://code.fieldsofview.in/phoenix/wiki/FOV-MPL2 */

package communication.messages;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * This class represents text messages is exchanged. The message is capable of
 * sending one object and records the time-stamp, source and destination.
 */
public class TextMessage extends Message {

    public int AC_STATUS;

    /**
     * Constructor creates an empty message object with current system time as
     * time stamp. NOTE: The time stamp is the current system time on which the
     * simulation is running.
     */
    // TODO: Check if different time zones will affect message time stamps
    public TextMessage() {
        createMessage();
    }

    protected void createMessage() {
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        this.timestamp = new Timestamp(now.getTime());
        this.messageObject = new String();
    }
}
