package data;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
        
/**
 *
 * @author huy
 */

@Entity
public class Word implements Serializable{
   
    private int id;
    private String word;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public String getWord(){
        return word;
    }
    
    public void setWord(String word){
        this.word = word;
    }
    
}
