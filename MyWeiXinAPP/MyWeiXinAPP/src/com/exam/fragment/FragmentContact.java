package com.exam.fragment;

import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.exam.myweixinapp.R;

public class FragmentContact extends Fragment implements LoaderCallbacks<Cursor>,OnItemClickListener{

	/**
	 * Defines an array that contains column names to move form the Cursor to the ListView 
	 * */
	private final static String [] FROM_COLUMNS={
		Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB?
				Contacts.DISPLAY_NAME_PRIMARY:Contacts.DISPLAY_NAME
	};
	/**
	 *  Defines an array that contains resource ids for the layout views
     * that get the Cursor column contents.
	 **/
	private final static int [] TO_IDS={R.id.contact_item};
	
	//Define a ListView object
	private ListView mContactsListView;
	
    // An adapter that binds the result Cursor to the ListView
    private SimpleCursorAdapter mCursorAdapter;
    private final static String [] PROJECTION={
    	Contacts._ID,
    	Contacts.LOOKUP_KEY,
    	Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB?
				Contacts.DISPLAY_NAME_PRIMARY:Contacts.DISPLAY_NAME
    };
    // The column index for the _ID column
    private static final int CONTACT_ID_INDEX = 0;
    // The column index for the LOOKUP_KEY column
    private static final int LOOKUP_KEY_INDEX = 1;
 // Defines the text expression
    private static final String SELECTION =
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
            Contacts.DISPLAY_NAME_PRIMARY + " LIKE ?" :
            Contacts.DISPLAY_NAME + " LIKE ?";
    // Defines a variable for the search string
    private String mSearchString="";
    // Defines the array to hold values that replace the ?
    private String[] mSelectionArgs = { mSearchString };
    
    /**
     * 	 // The contact's _ID value
    long mContactId;
    
    // The contact's LOOKUP_KEY
    String mContactKey;
    // A content URI for the selected contact
    Uri mContactUri;
     * */
    
    // Empty public constructor, required by the system
    public FragmentContact(){
    }
    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView=inflater.inflate(R.layout.fragment_contact, container, false);
		//View rootView=getActivity().findViewById(R.layout.fragment_contact);
		
		//mContactsListView.setOnItemClickListener(this);
		//System.out.println("----FragmentContact.onCreateView()");
		//return mContactsListView;
		return rootView;
	}

	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		mContactsListView=(ListView)getView().findViewById(android.R.id.list);
		
		// Gets a CursorAdapter
		mCursorAdapter=new SimpleCursorAdapter(getActivity(), R.layout.contacts_list_item, null, FROM_COLUMNS, TO_IDS, 0);
		// Sets the adapter for the ListView
		mContactsListView.setAdapter(mCursorAdapter);
		// Initializes the loader
		getLoaderManager().initLoader(0, null, this);
	}

	@Override
	public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
		// TODO Auto-generated method stub
		 /*
         * Makes search string into pattern and
         * stores it in the selection array
         */
		mSelectionArgs[0]="%"+mSearchString+"%";
		// Starts the query
		return new CursorLoader(getActivity(), Contacts.CONTENT_URI, PROJECTION, SELECTION, mSelectionArgs, null);
	}

	@Override
	public void onLoadFinished(Loader<Cursor> arg0, Cursor cursor) {
		// TODO Auto-generated method stub
		// Put the result Cursor in the adapter for the ListView
		mCursorAdapter.swapCursor(cursor);
		
	}

	@Override
	public void onLoaderReset(Loader<Cursor> arg0) {
		// TODO Auto-generated method stub
		 // Delete the reference to the existing Cursor
		mCursorAdapter.swapCursor(null);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}
	

}
