/*
 * Copyright (C) 2004-2014 L2J DataPack
 * 
 * This file is part of L2J DataPack.
 * 
 * L2J DataPack is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * L2J DataPack is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package custom.VotingReward.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ScopeContainer
{
	private final Map<String, Long> _votters = new ConcurrentHashMap<>();
	
	public void registerVotter(String data, long reuse)
	{
		_votters.put(data, reuse);
	}
	
	public long getReuse(String data)
	{
		if (_votters.containsKey(data))
		{
			long time = _votters.get(data);
			if (time > System.currentTimeMillis())
			{
				return time;
			}
		}
		return 0;
	}
}