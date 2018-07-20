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
 * The LeftBidirectional
 * 
 * @author kukulkan
 *
 */
@Entity
@Table(name = "left_bidirectional")
public class LeftBidirectional implements Serializable {

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
	    
    @OneToOne
    @JoinColumn(name = "recursive_child_one_to_one_bidirectional_id", unique = true)
    private LeftBidirectional recursiveChildOneToOneBidirectional;
    
    @OneToMany(mappedBy = "recursiveParentOneToManyBidirectional")
    @JsonIgnore
    private Set<LeftBidirectional> recursiveChildrenOneToManyBidirectional = new HashSet<>();
    
    @ManyToOne
    @JoinColumn(name = "recursive_child_many_to_one_bidirectional_id")
    private LeftBidirectional recursiveChildManyToOneBidirectional;
    
    @ManyToMany
    @JoinTable(name = "recursive_parent_many_to_many_bidirectional_recursive_children_many_to_many_bidirectional",
               joinColumns = @JoinColumn(name="recursive_parent_many_to_many_bidirectional_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="recursive_children_many_to_many_bidirectional_id", referencedColumnName="id"))
    private Set<LeftBidirectional> recursiveChildrenManyToManyBidirectional = new HashSet<>();
    
    @ManyToMany
    @JoinTable(name = "left_many_to_many_bidirectional_right_many_to_many_bidirectional",
               joinColumns = @JoinColumn(name="left_many_to_many_bidirectional_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="right_many_to_many_bidirectional_id", referencedColumnName="id"))
    private Set<RightManyToManyBidirectional> rightManyToManyBidirectional = new HashSet<>();
    
    @ManyToOne
    @JoinColumn(name = "right_many_to_one_bidirectional_id")
    private RightManyToOneBidirectional rightManyToOneBidirectional;
    
    @OneToMany(mappedBy = "leftOneToManyBidirectional")
    @JsonIgnore
    private Set<RightOneToManyBidirectional> rightOneToManyBidirectional = new HashSet<>();
    
    @OneToOne
    @JoinColumn(name = "right_one_to_one_bidirectional_id", unique = true)
    private RightOneToOneBidirectional rightOneToOneBidirectional;

	@JsonIgnore
    @OneToOne(mappedBy = "recursiveChildOneToOneBidirectional")
    private LeftBidirectional recursiveParentOneToOneBidirectional;
    	
    @ManyToOne
    @JoinColumn(name = "recursive_parent_one_to_many_bidirectional_id")
    private LeftBidirectional recursiveParentOneToManyBidirectional;
    	
    @OneToMany(mappedBy = "recursiveChildManyToOneBidirectional")
    private Set<LeftBidirectional> recursiveParentManyToOneBidirectional = new HashSet<>();
    	
    @ManyToMany(mappedBy = "recursiveChildrenManyToManyBidirectional")
    @JsonIgnore
    private Set<LeftBidirectional> recursiveParentManyToManyBidirectional = new HashSet<>();
    
    /**
     * Este método fue generado automaticamente por kukulkan 
     * Este método GETTER fue generado para la llave primaria left_bidirectional.id
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
     * Este método SETTER fue generado para la llave primaria. left_bidirectional.id
     *
     * @return el valor de id
     *
     * @kukulkanGenerated 20180101000000
     */
    public void setId(Long id) {
        this.id = id;
    }

	    public LeftBidirectional getRecursiveParentOneToOneBidirectional() {
        return recursiveParentOneToOneBidirectional;
    }

    public void setRecursiveParentOneToOneBidirectional(LeftBidirectional recursiveParentOneToOneBidirectional) {
        this.recursiveParentOneToOneBidirectional = recursiveParentOneToOneBidirectional;
    }
    
    public LeftBidirectional getRecursiveParentOneToManyBidirectional() {
        return recursiveParentOneToManyBidirectional;
    }

    public void setRecursiveParentOneToManyBidirectional(LeftBidirectional recursiveParentOneToManyBidirectional) {
        this.recursiveParentOneToManyBidirectional = recursiveParentOneToManyBidirectional;
    }
    
    public Set<LeftBidirectional> getRecursiveParentManyToOneBidirectional() {
        return recursiveParentManyToOneBidirectional;
    }
    
    public LeftBidirectional addRecursiveParentManyToOneBidirectional(LeftBidirectional recursiveParentManyToOneBidirectional) {
        this.recursiveParentManyToOneBidirectional.add(recursiveParentManyToOneBidirectional);
        recursiveParentManyToOneBidirectional.setRecursiveChildManyToOneBidirectional(this);
        return this;
    }

    public LeftBidirectional removeRecursiveParentManyToOneBidirectional(LeftBidirectional recursiveParentManyToOneBidirectional) {
        this.recursiveParentManyToOneBidirectional.remove(recursiveParentManyToOneBidirectional);
        recursiveParentManyToOneBidirectional.setRecursiveChildManyToOneBidirectional(null);
        return this;
    }

    public void setRecursiveParentManyToOneBidirectional(Set<LeftBidirectional> recursiveParentManyToOneBidirectional) {
        this.recursiveParentManyToOneBidirectional = recursiveParentManyToOneBidirectional;
    }
    
    public Set<LeftBidirectional> getRecursiveParentManyToManyBidirectional() {
        return recursiveParentManyToManyBidirectional;
    }
    
    public LeftBidirectional addRecursiveParentManyToManyBidirectional(LeftBidirectional recursiveParentManyToManyBidirectional) {
        this.recursiveParentManyToManyBidirectional.add(recursiveParentManyToManyBidirectional);
        recursiveParentManyToManyBidirectional.getRecursiveChildrenManyToManyBidirectional().add(this);
        return this;
    }

    public LeftBidirectional removeRecursiveParentManyToManyBidirectional(LeftBidirectional recursiveParentManyToManyBidirectional) {
        this.recursiveParentManyToManyBidirectional.remove(recursiveParentManyToManyBidirectional);
        recursiveParentManyToManyBidirectional.getRecursiveChildrenManyToManyBidirectional().remove(this);
        return this;
    }

    public void setRecursiveParentManyToManyBidirectional(Set<LeftBidirectional> recursiveParentManyToManyBidirectional) {
        this.recursiveParentManyToManyBidirectional = recursiveParentManyToManyBidirectional;
    }
    
    public LeftBidirectional getRecursiveChildOneToOneBidirectional() {
        return recursiveChildOneToOneBidirectional;
    }

    public void setRecursiveChildOneToOneBidirectional(LeftBidirectional recursiveChildOneToOneBidirectional) {
        this.recursiveChildOneToOneBidirectional = recursiveChildOneToOneBidirectional;
    }
    
    
    public Set<LeftBidirectional> getRecursiveChildrenOneToManyBidirectional() {
        return recursiveChildrenOneToManyBidirectional;
    }

    public LeftBidirectional addRecursiveChildrenOneToManyBidirectional(LeftBidirectional recursiveChildrenOneToManyBidirectional) {
        this.recursiveChildrenOneToManyBidirectional.add(recursiveChildrenOneToManyBidirectional);
        recursiveChildrenOneToManyBidirectional.setRecursiveParentOneToManyBidirectional(this);
        return this;
    }

    public LeftBidirectional removeRecursiveChildrenOneToManyBidirectional(LeftBidirectional recursiveChildrenOneToManyBidirectional) {
        this.recursiveChildrenOneToManyBidirectional.remove(recursiveChildrenOneToManyBidirectional);
        recursiveChildrenOneToManyBidirectional.setRecursiveParentOneToManyBidirectional(null);
        return this;
    }

    public void setRecursiveChildrenOneToManyBidirectional(Set<LeftBidirectional> recursiveChildrenOneToManyBidirectional) {
        this.recursiveChildrenOneToManyBidirectional = recursiveChildrenOneToManyBidirectional;
    }
    
    public LeftBidirectional getRecursiveChildManyToOneBidirectional() {
        return recursiveChildManyToOneBidirectional;
    }

    public void setRecursiveChildManyToOneBidirectional(LeftBidirectional recursiveChildManyToOneBidirectional) {
        this.recursiveChildManyToOneBidirectional = recursiveChildManyToOneBidirectional;
    }
    
    
    public Set<LeftBidirectional> getRecursiveChildrenManyToManyBidirectional() {
        return recursiveChildrenManyToManyBidirectional;
    }

    public LeftBidirectional addRecursiveChildrenManyToManyBidirectional(LeftBidirectional recursiveChildrenManyToManyBidirectional) {
        this.recursiveChildrenManyToManyBidirectional.add(recursiveChildrenManyToManyBidirectional);
        recursiveChildrenManyToManyBidirectional.getRecursiveParentManyToManyBidirectional().add(this);
        return this;
    }

    public LeftBidirectional removeRecursiveChildrenManyToManyBidirectional(LeftBidirectional recursiveChildrenManyToManyBidirectional) {
        this.recursiveChildrenManyToManyBidirectional.remove(recursiveChildrenManyToManyBidirectional);
        recursiveChildrenManyToManyBidirectional.getRecursiveParentManyToManyBidirectional().remove(this);
        return this;
    }

    public void setRecursiveChildrenManyToManyBidirectional(Set<LeftBidirectional> recursiveChildrenManyToManyBidirectional) {
        this.recursiveChildrenManyToManyBidirectional = recursiveChildrenManyToManyBidirectional;
    }
    
    
    public Set<RightManyToManyBidirectional> getRightManyToManyBidirectional() {
        return rightManyToManyBidirectional;
    }

    public LeftBidirectional addRightManyToManyBidirectional(RightManyToManyBidirectional rightManyToManyBidirectional) {
        this.rightManyToManyBidirectional.add(rightManyToManyBidirectional);
        rightManyToManyBidirectional.getLeftManyToManyBidirectional().add(this);
        return this;
    }

    public LeftBidirectional removeRightManyToManyBidirectional(RightManyToManyBidirectional rightManyToManyBidirectional) {
        this.rightManyToManyBidirectional.remove(rightManyToManyBidirectional);
        rightManyToManyBidirectional.getLeftManyToManyBidirectional().remove(this);
        return this;
    }

    public void setRightManyToManyBidirectional(Set<RightManyToManyBidirectional> rightManyToManyBidirectional) {
        this.rightManyToManyBidirectional = rightManyToManyBidirectional;
    }
    
    public RightManyToOneBidirectional getRightManyToOneBidirectional() {
        return rightManyToOneBidirectional;
    }

    public void setRightManyToOneBidirectional(RightManyToOneBidirectional rightManyToOneBidirectional) {
        this.rightManyToOneBidirectional = rightManyToOneBidirectional;
    }
    
    
    public Set<RightOneToManyBidirectional> getRightOneToManyBidirectional() {
        return rightOneToManyBidirectional;
    }

    public LeftBidirectional addRightOneToManyBidirectional(RightOneToManyBidirectional rightOneToManyBidirectional) {
        this.rightOneToManyBidirectional.add(rightOneToManyBidirectional);
        rightOneToManyBidirectional.setLeftOneToManyBidirectional(this);
        return this;
    }

    public LeftBidirectional removeRightOneToManyBidirectional(RightOneToManyBidirectional rightOneToManyBidirectional) {
        this.rightOneToManyBidirectional.remove(rightOneToManyBidirectional);
        rightOneToManyBidirectional.setLeftOneToManyBidirectional(null);
        return this;
    }

    public void setRightOneToManyBidirectional(Set<RightOneToManyBidirectional> rightOneToManyBidirectional) {
        this.rightOneToManyBidirectional = rightOneToManyBidirectional;
    }
    
    public RightOneToOneBidirectional getRightOneToOneBidirectional() {
        return rightOneToOneBidirectional;
    }

    public void setRightOneToOneBidirectional(RightOneToOneBidirectional rightOneToOneBidirectional) {
        this.rightOneToOneBidirectional = rightOneToOneBidirectional;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LeftBidirectional leftBidirectional = (LeftBidirectional) o;
        if (leftBidirectional.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), leftBidirectional.getId());
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
