/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. and 
 * at http://code.fieldsofview.in/phoenix/wiki/FOV-MPL2 */

package agents.universe;

/*TODO Design the GIS Universe. This is work in progress. Need to integrate
 * with already present GIS modules for access to data and/or compliance to
 * standards and file formats.
 */
/**
 * The GIS universe can map each point in the universe to a real GIS location.
 */
public class UniverseGIS extends Universe {

	private double minLatitude, minLongitude, maxLatitude, maxLongitude;

	/**
	 * @return the maxLatitude
	 */
	public double getMaxLatitude() {
		return maxLatitude;
	}

	/**
	 * @param maxLatitude
	 *            the maxLatitude to set
	 */
	public void setMaxLatitude(double maxLatitude) {
		this.maxLatitude = maxLatitude;
	}

	/**
	 * @return the minLatitude
	 */
	public double getMinLatitude() {
		return minLatitude;
	}

	/**
	 * @param minLatitude
	 *            the minLatitude to set
	 */
	public void setMinLatitude(double minLatitude) {
		this.minLatitude = minLatitude;
	}

	/**
	 * @return the maxLongitude
	 */
	public double getMaxLongitude() {
		return maxLongitude;
	}

	/**
	 * @param maxLongitude
	 *            the maxLongitude to set
	 */
	public void setMaxLongitude(double maxLongitude) {
		this.maxLongitude = maxLongitude;
	}

	/**
	 * @return the minLongitude
	 */
	public double getMinLongitude() {
		return minLongitude;
	}

	/**
	 * @param minLongitude
	 *            the minLongitude to set
	 */
	public void setMinLongitude(double minLongitude) {
		this.minLongitude = minLongitude;
	}

}
