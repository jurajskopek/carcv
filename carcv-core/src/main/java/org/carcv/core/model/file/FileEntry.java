/* 
 * Copyright 2012 CarCV Development Team
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

package org.carcv.core.model.file;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.carcv.core.model.CarData;
import org.carcv.core.model.AbstractEntry;

/**
 * 
 */
@Entity
public class FileEntry extends AbstractEntry {

    /**
     * 
     */
    private static final long serialVersionUID = -8030471101247536237L;

    private List<FileCarImage> carImages;
    private CarData carData;

    @SuppressWarnings("unused")
    private FileEntry() {
        //intentionally empty
    }

    /**
     * @param carData
     * @param carImages
     */
    public FileEntry(CarData carData, List<FileCarImage> carImages) {
        this.carData = carData;
        this.carImages = carImages;
    }

    @Override
    @NotNull
    @Embedded
    public CarData getCarData() {
        return carData;
    }

    @Override
    @NotNull
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, targetEntity=FileCarImage.class)
    public List<FileCarImage> getCarImages() {
        return carImages;
    }

    /**
     * @param carImage
     *            the carImage to set
     */
    public void setCarImages(List<FileCarImage> carImages) {
        this.carImages = carImages;
    }

    /**
     * @param carData
     *            the carData to set
     */
    public void setCarData(CarData carData) {
        this.carData = carData;
    }

    @Override
    public String toString() {
        return "FileEntry[id=" + getId() + ", carImages.size()=" + carImages.size() + ", carData=" + carData.toString()
                + "]";
    }

}