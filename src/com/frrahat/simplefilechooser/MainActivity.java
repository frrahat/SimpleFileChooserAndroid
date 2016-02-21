package com.frrahat.simplefilechooser;

import java.io.File;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	
	public static final String startingFoldername="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//File formats shown in the dialog
		String[] acceptedFileFormats={".txt",".zip",".ttf",".apk",".pdf",".doc",".png"};
		
		//show or hide folders name starting with '.'
		boolean showHiddenFolders=false;
		
		FileChooserDialog fileChooserDialog=new FileChooserDialog(acceptedFileFormats,showHiddenFolders);
		
		//action after the target file is chosen
		fileChooserDialog.setOnFileChosenListener(
				new FileChooserDialog.OnFileChosenListener() {
			
			@Override
			public void onFileChosen(File file) {
				Toast.makeText(getBaseContext(), file.getName()+ " has been chosen", Toast.LENGTH_LONG).show();
				//read(file);
			}
		});
		
		//show the dialog
		fileChooserDialog.show(getFragmentManager(), "fileChooser");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		/*// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}*/
		return super.onOptionsItemSelected(item);
	}
}
