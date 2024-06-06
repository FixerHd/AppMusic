package ventanas;

public class PlaylistNameNotificactionService {
	private final PlaylistNameObserver observers;

	public PlaylistNameNotificactionService(PlaylistNameObserver observer) {
		observers = observer;
	}

	public String notifyObserver() {
		return observers.updateName();
	}
}
