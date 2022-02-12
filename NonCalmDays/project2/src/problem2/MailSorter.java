package problem2;

import java.util.ArrayList;
import java.util.Comparator;

public class MailSorter
{
	public static void SortMail(ArrayList<Mail> mails, boolean ascending) //with choice
	{	
		mails.sort(new Comparator<Mail>()
		{
			@Override
			public int compare(Mail o1, Mail o2)
			{
				return o1.compareTo(o2) * (ascending ? -1 : 1);
			}
		}
		);
	}
}