/**
 * 
 */
package org.carcv.core.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.carcv.core.model.file.FileCarImage;

/**
 * @author oskopek
 *
 */
@Entity
public class Car extends AbstractModel {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2506409391922336854L;

    private CarData carData;
    
    private FileCarImage carImage;
    
    
    @SuppressWarnings("unused")
    private Car() {
      //intentionally empty
    }
    
    public Car(CarData carData, FileCarImage carImage) {
        this.carData = carData;
        this.carImage = carImage;
    }

    /* (non-Javadoc)
     * @see org.carcv.core.model.AbstractCar#getCarData()
     */
    @NotNull
    @OneToOne
    public CarData getCarData() {
        return carData;
    }

    /* (non-Javadoc)
     * @see org.carcv.core.model.AbstractCar#getCarImage()
     */
    @NotNull
    @OneToOne
    public FileCarImage getCarImage() {
        return carImage;
    }
    

    /**
     * @param carData the carData to set
     */
    public void setCarData(CarData carData) {
        this.carData = carData;
    }

    /**
     * @param carImage the carImage to set
     */
    public void setCarImage(FileCarImage carImage) {
        this.carImage = carImage;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Car)) {
            return false;
        }
        Car other = (Car) obj;

        return new EqualsBuilder()
                .append(getCarData(), other.getCarData())
                .append(getCarImage(), other.getCarImage())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getCarData())
                .append(getCarImage())
                .toHashCode();
    }


}
