package ua.rd.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component("user")
@Scope("prototype")
public class User {
	private Long id;
	private String name;
	private List<Tweet> tweets = new ArrayList<>();
	private List<User> subscriptions = new ArrayList<>();

	public User(String name) {
		this.name = name;
	}

	public User() {
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}

	public List<User> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<User> subscriptions) {
		this.subscriptions = subscriptions;
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (id != null ? !id.equals(user.id) : user.id != null) return false;
		if (tweets != null ? !tweets.equals(user.tweets) : user.tweets != null) return false;
		if (subscriptions != null ? !subscriptions.equals(user.subscriptions) : user.subscriptions != null)
			return false;
		return name != null ? name.equals(user.name) : user.name == null;

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (tweets != null ? tweets.hashCode() : 0);
		result = 31 * result + (subscriptions != null ? subscriptions.hashCode() : 0);
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", tweets=" + tweets +
				", subscriptions=" + subscriptions +
				", name='" + name + '\'' +
				'}';
	}
}
