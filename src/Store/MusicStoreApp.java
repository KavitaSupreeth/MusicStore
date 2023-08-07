package Store;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class MusicStoreApp {

	public static ArrayDeque<String> songs = new ArrayDeque<String>();
	public static Map<String, ArrayDeque<String>> playlist = new HashMap<String, ArrayDeque<String>>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		MusicStoreApp t = new MusicStoreApp();
		RecentPlaylistQueue q = t.new RecentPlaylistQueue(4);
		Scanner sc = new Scanner(System.in);
		int ch;

		do {
			System.out.println("***--Please Enter your Choice--***\n");
			System.out.println("1) Create user\n");
			System.out.println("2) Play songs for the user\n");
			System.out.println("3) Exit the music store\n");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Creating user");
				songs = new ArrayDeque<String>();
				MusicStoreApp.prepareInitialPlaylist();
				break;

			case 2:
				q.addSong();
				break;

			case 3:
				System.out.println("Exiting the music store");
				break;

			default:
				System.out.println("invalid Choice Please rerun the prog");
				break;

			}
		} while (ch != 3);

	}

	public static void prepareInitialPlaylist() {
		try {
			System.out.println("Enter the user name");
			String name = sc.next();
			int size = 0;
			do {
				System.out.println("Enter Store capacity for user: " + name);
				size = sc.nextInt();
				if (size >= 1) {
					System.out.println("Enter " + size + " songs for " + name);

					for (int i = 0; i < size; i++) {
						String songName = sc.next();
						songs.add(songName);
					}
					playlist.put(name, songs);
					System.out.println(playlist);
				} else {
					System.out.println(
							"Please add valid Store Capacity \n\n*Note Store Capacity should be an integer value");
					continue;
				}
			} while (size < 1);
		} catch (Exception e) {
			e.getMessage();
			System.out.println("Please print integer value");
		}
	}

	class RecentPlaylistQueue {
		int limit = 4;
		LinkedList<String> list = new LinkedList<>();
		Map<String, LinkedList<String>> recentPlaylist = new HashMap<String, LinkedList<String>>();

		public RecentPlaylistQueue(int limit) {
			this.limit = limit;
		}

		public void addSong() {

			String ch2 = "";
			System.out.println("Select the user from the Userlist-> " + playlist.keySet());
			String Username = sc.next();

			if (playlist.containsKey(Username)) {
				do {
					System.out.println("Recent playlist of " + Username + " is" + list);
					System.out.println("Enter the song name ");
					System.out.println("Your saved playlist is " + playlist.get(Username));
					String addSong = sc.next();

					if (!list.contains(addSong)) {

						if (list.size() >= limit) {
							list.poll();
						}
						System.out.println("Playing your song... " + addSong);
						list.add(addSong);

					} else {
						list.remove(addSong);
						System.out.println("Playing your song... " + addSong);
						list.add(addSong);
					}

					System.out.println("Do you wish to listen to other song? y /n");
					ch2 = sc.next();

				} while (ch2.equalsIgnoreCase("y"));

				if (ch2.equalsIgnoreCase("n")) {
					recentPlaylist.put(Username, list);
					System.out.println("Recent playlist of user is" + recentPlaylist);
				}
			} else {
				System.out.println("Please enter valid user name from the list" + playlist.keySet());
			}

		}

		@Override
		public String toString() {
			return "Queue{" + ", list=" + list + '}';
		}
	}

}
