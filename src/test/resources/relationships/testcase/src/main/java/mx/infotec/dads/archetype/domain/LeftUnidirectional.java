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
 * The LeftUnidirectional
 * 
 * @author kukulkan
 *
 */
@Entity
@Table(name = "left_unidirectional")
public class LeftUnidirectional implements Serializable {

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
    @JoinColumn(name = "recursive_child_one_to_one_unidirectional_id", unique = true)
    private LeftUnidirectional recursiveChildOneToOneUnidirectional;
    
    @OneToMany(mappedBy = "leftUnidirectional")
    @JsonIgnore
    private Set<LeftUnidirectional> recursiveChildrenOneToManyUnidirectional = new HashSet<>();
    
    @ManyToOne
    @JoinColumn(name = "recursive_child_many_to_one_unidirectional_id")
    private LeftUnidirectional recursiveChildManyToOneUnidirectional;
    
    @ManyToMany
    @JoinTable(name = "left_unidirectional_recursive_children_many_to_many_unidirectional",
               joinColumns = @JoinColumn(name="left_unidirectional_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="recursive_children_many_to_many_unidirectional_id", referencedColumnName="id"))
    private Set<LeftUnidirectional> recursiveChildrenManyToManyUnidirectional = new HashSet<>();
    
    @ManyToMany
    @JoinTable(name = "left_unidirectional_many_to_many_unidirectional",
               joinColumns = @JoinColumn(name="left_unidirectional_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="many_to_many_unidirectional_id", referencedColumnName="id"))
    private Set<RightManyToManyUnidirectional> manyToManyUnidirectional = new HashSet<>();
    
    @ManyToOne
    @JoinColumn(name = "many_to_one_unidirectional_id")
    private RightManyToOneUnidirectional manyToOneUnidirectional;
    
    @OneToMany(mappedBy = "leftUnidirectional")
    @JsonIgnore
    private Set<RightOneToManyUnidirectional> oneToManyUnidirectional = new HashSet<>();
    
    @OneToOne
    @JoinColumn(name = "one_to_one_unidirectional_id", unique = true)
    private RightOneToOneUnidirectional oneToOneUnidirectional;

    	
    @ManyToOne
    @JoinColumn(name = "left_unidirectional_id")
    private LeftUnidirectional leftUnidirectional;
    /**
     * Este método fue generado automaticamente por kukulkan 
     * Este método GETTER fue generado para la llave primaria left_unidirectional.id
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
     * Este método SETTER fue generado para la llave primaria. left_unidirectional.id
     *
     * @return el valor de id
     *
     * @kukulkanGenerated 20180101000000
     */
    public void setId(Long id) {
        this.id = id;
    }

	    public LeftUnidirectional getLeftUnidirectional() {
        return leftUnidirectional;
    }

    public void setLeftUnidirectional(LeftUnidirectional leftUnidirectional) {
        this.leftUnidirectional = leftUnidirectional;
    }
    
    public LeftUnidirectional getRecursiveChildOneToOneUnidirectional() {
        return recursiveChildOneToOneUnidirectional;
    }

    public void setRecursiveChildOneToOneUnidirectional(LeftUnidirectional recursiveChildOneToOneUnidirectional) {
        this.recursiveChildOneToOneUnidirectional = recursiveChildOneToOneUnidirectional;
    }
    
    
    public Set<LeftUnidirectional> getRecursiveChildrenOneToManyUnidirectional() {
        return recursiveChildrenOneToManyUnidirectional;
    }

    public LeftUnidirectional addRecursiveChildrenOneToManyUnidirectional(LeftUnidirectional recursiveChildrenOneToManyUnidirectional) {
        this.recursiveChildrenOneToManyUnidirectional.add(recursiveChildrenOneToManyUnidirectional);
        recursiveChildrenOneToManyUnidirectional.setLeftUnidirectional(this);
        return this;
    }

    public LeftUnidirectional removeRecursiveChildrenOneToManyUnidirectional(LeftUnidirectional recursiveChildrenOneToManyUnidirectional) {
        this.recursiveChildrenOneToManyUnidirectional.remove(recursiveChildrenOneToManyUnidirectional);
        recursiveChildrenOneToManyUnidirectional.setLeftUnidirectional(null);
        return this;
    }

    public void setRecursiveChildrenOneToManyUnidirectional(Set<LeftUnidirectional> recursiveChildrenOneToManyUnidirectional) {
        this.recursiveChildrenOneToManyUnidirectional = recursiveChildrenOneToManyUnidirectional;
    }
    
    public LeftUnidirectional getRecursiveChildManyToOneUnidirectional() {
        return recursiveChildManyToOneUnidirectional;
    }

    public void setRecursiveChildManyToOneUnidirectional(LeftUnidirectional recursiveChildManyToOneUnidirectional) {
        this.recursiveChildManyToOneUnidirectional = recursiveChildManyToOneUnidirectional;
    }
    
    
    public Set<LeftUnidirectional> getRecursiveChildrenManyToManyUnidirectional() {
        return recursiveChildrenManyToManyUnidirectional;
    }

    public LeftUnidirectional addRecursiveChildrenManyToManyUnidirectional(LeftUnidirectional recursiveChildrenManyToManyUnidirectional) {
        this.recursiveChildrenManyToManyUnidirectional.add(recursiveChildrenManyToManyUnidirectional);
        return this;
    }

    public LeftUnidirectional removeRecursiveChildrenManyToManyUnidirectional(LeftUnidirectional recursiveChildrenManyToManyUnidirectional) {
        this.recursiveChildrenManyToManyUnidirectional.remove(recursiveChildrenManyToManyUnidirectional);
        return this;
    }

    public void setRecursiveChildrenManyToManyUnidirectional(Set<LeftUnidirectional> recursiveChildrenManyToManyUnidirectional) {
        this.recursiveChildrenManyToManyUnidirectional = recursiveChildrenManyToManyUnidirectional;
    }
    
    
    public Set<RightManyToManyUnidirectional> getManyToManyUnidirectional() {
        return manyToManyUnidirectional;
    }

    public LeftUnidirectional addManyToManyUnidirectional(RightManyToManyUnidirectional manyToManyUnidirectional) {
        this.manyToManyUnidirectional.add(manyToManyUnidirectional);
        return this;
    }

    public LeftUnidirectional removeManyToManyUnidirectional(RightManyToManyUnidirectional manyToManyUnidirectional) {
        this.manyToManyUnidirectional.remove(manyToManyUnidirectional);
        return this;
    }

    public void setManyToManyUnidirectional(Set<RightManyToManyUnidirectional> manyToManyUnidirectional) {
        this.manyToManyUnidirectional = manyToManyUnidirectional;
    }
    
    public RightManyToOneUnidirectional getManyToOneUnidirectional() {
        return manyToOneUnidirectional;
    }

    public void setManyToOneUnidirectional(RightManyToOneUnidirectional manyToOneUnidirectional) {
        this.manyToOneUnidirectional = manyToOneUnidirectional;
    }
    
    
    public Set<RightOneToManyUnidirectional> getOneToManyUnidirectional() {
        return oneToManyUnidirectional;
    }

    public LeftUnidirectional addOneToManyUnidirectional(RightOneToManyUnidirectional oneToManyUnidirectional) {
        this.oneToManyUnidirectional.add(oneToManyUnidirectional);
        oneToManyUnidirectional.setLeftUnidirectional(this);
        return this;
    }

    public LeftUnidirectional removeOneToManyUnidirectional(RightOneToManyUnidirectional oneToManyUnidirectional) {
        this.oneToManyUnidirectional.remove(oneToManyUnidirectional);
        oneToManyUnidirectional.setLeftUnidirectional(null);
        return this;
    }

    public void setOneToManyUnidirectional(Set<RightOneToManyUnidirectional> oneToManyUnidirectional) {
        this.oneToManyUnidirectional = oneToManyUnidirectional;
    }
    
    public RightOneToOneUnidirectional getOneToOneUnidirectional() {
        return oneToOneUnidirectional;
    }

    public void setOneToOneUnidirectional(RightOneToOneUnidirectional oneToOneUnidirectional) {
        this.oneToOneUnidirectional = oneToOneUnidirectional;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LeftUnidirectional leftUnidirectional = (LeftUnidirectional) o;
        if (leftUnidirectional.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), leftUnidirectional.getId());
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
