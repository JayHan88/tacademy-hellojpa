package hellojpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Member {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "USERNAME", nullable = false, length = 20)
	private String name;
	private int age;

	// @ManyToOne(fetch = FetchType.EAGER) // JOIN 해서 미리 가져옴
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEAM_ID")
	private Team team;

//	@Column(name = "TEAM_ID")
//	private Long teamId;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Member{" +
			       "id=" + id +
			       ", name='" + name + '\'' +
			       ", age=" + age +
			       ", team=" + team +
			       '}';
	}
}
