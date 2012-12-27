package com.bomba.b;

import java.util.ArrayList;
import java.util.HashMap;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;

import android.util.Log;

import android.widget.ListView;
//import android.widget.SearchView;

import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.SearchView;
import com.actionbarsherlock.widget.SearchView.OnQueryTextListener;

import com.bomba.database.DbHelper;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingActivity;

public class Searchy extends SlidingActivity implements OnQueryTextListener {
	ListView tracks;
	String pls;
	Bundle m;
	DbHelper pickTracks;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		pls = getIntent().getExtras().getString("p");
		getSupportActionBar().setTitle(pls);

		setContentView(R.layout.s_view);
		setBehindContentView(R.layout.slide);
		SlidingMenu sm = getSlidingMenu();
		sm.setMode(SlidingMenu.LEFT);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setFadeDegree(0.35f);
		sm.setMenu(R.layout.slide);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		init();

	}

	private void init() {
		tracks = (ListView) findViewById(R.id.listofTracks);
		pickTracks = new DbHelper(Searchy.this);
		pickTracks.open();
		if (pickTracks.DoesPlaylistExist(pls)) {
			loadList l = new loadList();
			l.execute(pls);
		} else {
			Toast.makeText(Searchy.this,
					"Please search for a track to add to this playlist",
					Toast.LENGTH_LONG).show();
		}

	}

	public class loadSearched extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... arg0) {

			return null;
		}

	}

	public class loadList extends AsyncTask<String, Void, Void> {
		ArrayList<HashMap<String, String>> what;

		@Override
		protected Void doInBackground(String... st) {
			pickTracks = new DbHelper(Searchy.this);
			pickTracks.open();
			what = pickTracks.getTracks(st[0]);

			pickTracks.close();

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if (what != null) {
				SimpleAdapter adp = new SimpleAdapter(Searchy.this, what,
						android.R.layout.simple_list_item_2, new String[] {
								"name", "per" }, new int[] {
								android.R.id.text1, android.R.id.text2 });
				tracks.setAdapter(adp);

			} else {
				Toast.makeText(Searchy.this, "Search tracks to add to list",
						Toast.LENGTH_LONG).show();
				Log.v("async", "the arraylist is empty");
			}
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		com.actionbarsherlock.widget.SearchView searchView = new com.actionbarsherlock.widget.SearchView(
				getSupportActionBar().getThemedContext());
		searchView.setQueryHint("Search for Track");
		menu.add(0, 1, 1, "playlist")
				.setIcon(R.drawable.ic_action_search)
				.setActionView(searchView)
				.setShowAsAction(
						MenuItem.SHOW_AS_ACTION_IF_ROOM
								| MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);

		return true;
	}

	@SuppressLint("NewApi")
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		Log.v("SearchItem", item.getItemId() + "");

		switch (item.getItemId()) {
		case 1:

			SearchView sv = (SearchView) item.getActionView();
			sv.setOnQueryTextListener(this);

			// onSearchRequested();
			break;
		}

		return true;
	}

	@Override
	protected void onDestroy() {

		super.onDestroy();
		pickTracks.close();
	}

	@Override
	protected void onPause() {

		super.onPause();
		pickTracks.close();

	}

	@Override
	public boolean onQueryTextSubmit(String query) {

		// pull data from the cursor
		Log.v("SEARCHY", "loading songs from db");
		populateSongs p = new populateSongs();
		p.execute(query);

		return false;
	}

	@Override
	public boolean onQueryTextChange(String newText) {

		return false;
	}

	public class populateSongs extends AsyncTask<String, Void, Void> {
		Cursor mCursor;

		@Override
		protected void onPostExecute(Void result) {
			if (mCursor.getCount() <= 0) {
				Toast.makeText(
						Searchy.this,
						"We don't have any tracks with that name but we will look around",
						Toast.LENGTH_LONG).show();
			}
			else
			{
				ListAdapter adp = new SimpleCursorAdapter(Searchy.this,
						R.layout.searchrow, mCursor,
						new String[] { pickTracks.SONGS_ARTIST_ID,
								pickTracks.SONGS_NAME }, new int[] { R.id.tvs_a_id,
								R.id.tv_songs_name });
				tracks.setAdapter(adp);

				
			}
			
			super.onPostExecute(result);
		}

		@Override
		protected Void doInBackground(String... params) {
			// TODO Auto-generated method stub
			pickTracks.open();
			mCursor = pickTracks.getSearched(params[0]);
			Log.v("SEARCHY", mCursor.getCount() + "");
			startManagingCursor(mCursor);
			return null;
		}
	}
}
