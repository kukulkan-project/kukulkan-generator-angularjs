/*
 *  
 * The MIT License (MIT)
 * Copyright (c) 2018 kukulkan
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mx.infotec.dads.archetype.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import java.util.Objects;
import java.io.Serializable;

/**
 * The RightManyToManyBidirectional
 * 
 * @author kukulkan
 *
 */
@Entity
@Table(name = "right_many_to_many_bidirectional")
public class RightManyToManyBidirectional implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * Este campo fue generado automaticamente por kukulkan 
     * Este campo corresponde a la llave primaria id
     *
     * @kukulkanGenerated 20180101000000
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
	
    	
    @ManyToMany(mappedBy = "rightManyToManyBidirectional")
    @JsonIgnore
    private Set<LeftBidirectional> leftManyToManyBidirectional = new HashSet<>();
    
    /**
     * Este método fue generado automaticamente por kukulkan 
     * Este método GETTER fue generado para la llave primaria right_many_to_many_bidirectional.id
     *
     * @return el valor de id
     *
     * @kukulkanGenerated 20180101000000
     */
    public Long getId() {
        return id;
    }

    /**
     * Este método fue generado automaticamente por kukulkan 
     * Este método SETTER fue generado para la llave primaria. right_many_to_many_bidirectional.id
     *
     * @return el valor de id
     *
     * @kukulkanGenerated 20180101000000
     */
    public void setId(Long id) {
        this.id = id;
    }

	    public Set<LeftBidirectional> getLeftManyToManyBidirectional() {
        return leftManyToManyBidirectional;
    }
    
    public RightManyToManyBidirectional addLeftManyToManyBidirectional(LeftBidirectional leftManyToManyBidirectional) {
        this.leftManyToManyBidirectional.add(leftManyToManyBidirectional);
        leftManyToManyBidirectional.getRightManyToManyBidirectional().add(this);
        return this;
    }

    public RightManyToManyBidirectional removeLeftManyToManyBidirectional(LeftBidirectional leftManyToManyBidirectional) {
        this.leftManyToManyBidirectional.remove(leftManyToManyBidirectional);
        leftManyToManyBidirectional.getRightManyToManyBidirectional().remove(this);
        return this;
    }

    public void setLeftManyToManyBidirectional(Set<LeftBidirectional> leftManyToManyBidirectional) {
        this.leftManyToManyBidirectional = leftManyToManyBidirectional;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RightManyToManyBidirectional rightManyToManyBidirectional = (RightManyToManyBidirectional) o;
        if (rightManyToManyBidirectional.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rightManyToManyBidirectional.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
                sb.append("]");
        return sb.toString();
    }
}
