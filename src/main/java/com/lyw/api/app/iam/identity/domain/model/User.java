package com.lyw.api.app.iam.identity.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id = ?")
public class User implements Serializable {
    @Id
    private String id;

    @Column(name = "email")
    private String email;

    @Column(name = "google_name")
    private String googleName;

    @Column(name = "google_photo_url")
    private String googlePhotoUrl;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id")
    private Role role;

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    private Date createdDate;

    @Column(name = "deleted")
    private Boolean deleted;

    @PrePersist
    private void prePersist() {
        deleted = false;
        createdDate = new Date();
    }
}