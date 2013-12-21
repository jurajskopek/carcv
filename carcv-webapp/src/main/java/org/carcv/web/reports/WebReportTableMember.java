/*
 * Copyright 2013 CarCV Development Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.carcv.web.reports;

/**
 *
 */
public class WebReportTableMember {

    final private String previewPath, entryId, time, date, location, licensePlate, timeZone;

    /**
     * @param previewPath
     * @param entryId
     * @param time
     * @param date
     * @param location
     * @param licensePlate
     */
    public WebReportTableMember(String previewPath, String entryId, String time, String date, String location,
        String licensePlate, String timeZone) {
        this.previewPath = previewPath;
        this.entryId = entryId;
        this.time = time;
        this.date = date;
        this.location = location;
        this.licensePlate = licensePlate;
        this.timeZone = timeZone;
    }

    /**
     * @return the previewPath
     */
    public String getPreviewPath() {
        return previewPath;
    }

    /**
     * @return the entryId
     */
    public String getEntryId() {
        return entryId;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @return the licensePlate
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     *
     * @return the timeZone
     */
    public String getTimeZone() {
        return timeZone;
    }
}