package com.study.spring.board.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="image")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String originalFileName;
	private String fileName;
	private Integer imageOrder;
	
//	private String boardId;
	
	@ManyToOne
	@JoinColumn(name="board_id")
	private Board board;
	
	private LocalDateTime createdAt;
	
	@PrePersist
	public void onCreate() {
		this.createdAt = LocalDateTime.now();
		if(imageOrder==null) imageOrder=0;
	}
	
	
	
	
	
	
	
	
	
	
	
}
