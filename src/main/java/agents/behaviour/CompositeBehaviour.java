/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. and 
 * at http://code.fieldsofview.in/phoenix/wiki/FOV-MPL2 */

package agents.behaviour;

import java.util.ArrayList;

import agents.attributes.AgentAttributes;

/**
 * This behaviour allows the agents to execute one behaviour after another in a
 * list. Each agent has only one composite behaviour. However, multiple
 * behaviours can be grouped within the composite behaviour.
 */

// TODO a scheduling mechanism may be defined for the entire list.
public class CompositeBehaviour implements Behaviour {

	private final ArrayList<Behaviour> behaviours = new ArrayList<Behaviour>();

	/**
	 * To add a new behaviour to the end of the list.
	 * 
	 * @param newBehaviour
	 *            the new behaviour to be added
	 */
	public void add(Behaviour newBehaviour) {
		behaviours.add(newBehaviour);
	}

	/**
	 * To add a new behaviour at a specified index in the list.
	 * 
	 * @param newBehaviour
	 *            the new behaviour to be added.
	 * @param index
	 *            the index at which the behaviour needs to be added.
	 */
	public void add(Behaviour newBehaviour, int index) {
		behaviours.add(index, newBehaviour);
	}

	/**
	 * To remove the last behaviour from the end of the list.
	 * 
	 * @param newBehaviour
	 *            the behaviour to be removed,
	 */

	public void remove(Behaviour newBehaviour) {
		behaviours.remove(newBehaviour);
	}

	/**
	 * To clear all the behaviours from the list.
	 */
	public void purge() {
		behaviours.clear();
	}

	@Override
	public void run(AgentAttributes agentAttributes) {
		for (int i = 0; i < behaviours.size(); i++) {
			behaviours.get(i).run(agentAttributes);
		}
	}
}