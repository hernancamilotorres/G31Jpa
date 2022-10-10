
package com.g31.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Camilo Torres C
 */

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (nullable = false,length =255)
    private Long Score;

    /**
     * @return the Score
     */
    public Long getScore() {
        return Score;
    }

    /**
     * @param Score the Score to set
     */
    public void setScore(Long Score) {
        this.Score = Score;
    }
}
